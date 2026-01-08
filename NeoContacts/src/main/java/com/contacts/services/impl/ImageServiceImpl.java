package com.contacts.services.impl;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.contacts.services.ImgService;

public class ImageServiceImpl implements ImgService {
    
    private Cloudinary cloudinary;

    public void ImgServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    @Override
    public String uploadImage(MultipartFile contactImage) {
        String filename=UUID.randomUUID().toString();
        try{
            byte[] data= new byte[contactImage.getInputStream().available()];

            contactImage.getInputStream().read(data);

            cloudinary.uploader().upload(data,ObjectUtils.asMap("public_id",contactImage.getOriginalFilename()));
        }catch(Exception e){
            e.printStackTrace();    
        }
        
        return "";
    }

}
