package com.travel.vision.api.services;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.travel.vision.api.enums.DocumentType;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.Base64;
import java.util.UUID;

@Service
public class ImageStorage {
    private CloudStorageAccount cloudStorageAccount  = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;EndpointSuffix=core.windows.net;AccountName=travel_vision;AccountKey={Key}}");
    private static final String BASE_URL = "https://travel_vision.blob.core.windows.net/travel_vision/";

    public ImageStorage() throws URISyntaxException, InvalidKeyException {

    }
    public String upload(String base64, DocumentType documentType) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64);
            String fileName  = UUID.randomUUID().toString() + "." + documentType.toString().toLowerCase();
            final CloudBlobClient blobClient = cloudStorageAccount.createCloudBlobClient();
            final CloudBlobContainer container = blobClient.getContainerReference("travel_vision");

            CloudBlockBlob blob = container.getBlockBlobReference(fileName);
            blob.getProperties().setContentType(getType(documentType));
            blob.uploadFromByteArray(decodedBytes,0,decodedBytes.length);
            System.out.println("success upload." + blob.getUri().toString());

            return blob.getUri().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    void deleteBlobIfExist(String url) throws URISyntaxException, StorageException {
        final CloudBlobClient blobClient = cloudStorageAccount.createCloudBlobClient();
        final CloudBlobContainer container = blobClient.getContainerReference("travel_vision");
        CloudBlockBlob blob = container.getBlockBlobReference(url.replace(BASE_URL,""));
        blob.deleteIfExists();
    }
    private String getType(DocumentType documentType){
        if(documentType.toString().equals("PDF")){
            return "application/pdf";
        }
        return "image/"+documentType.toString().toLowerCase();
    }
}
