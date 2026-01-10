package com.contacts.validators;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile>{

    private static final long MAX_FILE_SIZE = 1024*1024*2;

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if(file==null|| file.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File cannot be empty").addConstraintViolation();
            return false;
        }

        if(file.getSize()>MAX_FILE_SIZE){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("File size exceeds the maximum limit of 2MB").addConstraintViolation();
            return false;
        }


        //resolution
        //

            //     try{
            //         BufferedImage bufferedImage= ImageIO.read(file.getInputStream());

            //         if(bufferedImage==null){
            //             context.disableDefaultConstraintViolation();
            //             context.buildConstraintViolationWithTemplate("Invalid image file").addConstraintViolation();
            //             return false;
            //         }
            //     }
            //     catch(Exception e){
            //         context.disableDefaultConstraintViolation();
            //         context.buildConstraintViolationWithTemplate("Invalid image file").addConstraintViolation();
            //         return false;
            // }

        return true;
    }

}
