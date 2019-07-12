package co.getmehired.getmehired.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dell on 09-Jul-19.
 */

@Service
public class FileService {


    public static final String BUCKET_NAME = "";  // Your bucket name
    public static final String S3_ACCESS_KEY = ""; // Your access key
    public static final String S3_SECRET_KEY = "";

    public static final String FOLDER = "";

    public void uploadFile(MultipartFile file) {

        BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        byte[] fileBytes = new byte[0];
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Uploading a new object to S3 from a file\n");
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("text");
        metadata.setContentLength(fileBytes.length);

        String path = FOLDER + "/" + file.getOriginalFilename();

        client.putObject(BUCKET_NAME, path, new ByteArrayInputStream(fileBytes), metadata);

        // TODO update database (call file repository) if upload is successful

        // TODO return FileMeta object
    }

    public ByteArrayOutputStream getFile(String path){

        BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        S3Object object = client.getObject(BUCKET_NAME, path);
        InputStream objectData = object.getObjectContent();

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(objectData, baos);
            objectData.close();

            return baos;
        } catch (Exception ex) {

        }
        return null;
    }


    // TODO Modify the method, take file id as input, search database, delete from amazon, update database
    public void delete() {

        BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        // TODO get file path from database
        client.deleteObject(BUCKET_NAME, "test/test.txt");

    }


}
