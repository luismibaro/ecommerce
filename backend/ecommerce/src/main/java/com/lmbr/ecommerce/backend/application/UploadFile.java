package com.lmbr.ecommerce.backend.application;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    // Define the folder where the uploaded images will be saved
    private final String FOLDER = "src//main//resources//static//images//";
    // Define the default image name that will be used if no image is uploaded
    private final String IMG_DEFAULT = "default.jpg";
    // Define the base URL to access the images
    private final String URL = "http://localhost:8085/images/";

    // Method to upload a file
    public String upload(MultipartFile multipartFile) throws IOException {
        // Check if the uploaded file is not null
        if (multipartFile != null) {
            // Convert the uploaded file to a byte array
            byte[] bytes = multipartFile.getBytes();
            // Create a path object with the directory and the original file name
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            // Write the byte array to the file path
            Files.write(path, bytes);
            // Return the URL of the uploaded image
            return URL + multipartFile.getOriginalFilename();
        }
        // If the file is null, return the URL of the default image
        return URL + IMG_DEFAULT;
    }

    // Method to delete a file
    public void delete(String nameFile) {
        // Create a file object with the directory and file name
        File file = new File(FOLDER + nameFile);
        // Delete the file
        file.delete();
    }
}
