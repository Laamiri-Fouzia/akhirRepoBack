package com.bezkoder.springjwt.service;


import com.bezkoder.springjwt.models.ImageModl;
import com.bezkoder.springjwt.repository.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageService {
    @Autowired
    private ImageDao imageDao;

    public Optional<ImageModl> findByName(String name) {
        return imageDao.findByName(name);
    }

    public int uplaodImage( MultipartFile file,String nameData) throws IOException {
        if(findByNameData(nameData)!=null){
            return -1;
        }
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageModl img = new ImageModl(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));
        img.setNameData(nameData);
        imageDao.save(img);
        return 1;
    }

    public ImageModl getImage(String imageName) throws IOException {
        final ImageModl retrievedImage = imageDao.findByNameData(imageName);
        ImageModl img = new ImageModl(retrievedImage.getName(), retrievedImage.getType(),
                decompressBytes(retrievedImage.getPicByte()));
        return img;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

    public ImageModl findByNameData(String nameData) {
        return imageDao.findByNameData(nameData);
    }
}
