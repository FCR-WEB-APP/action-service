package com.example.Action.Service;

import com.example.Action.Dao.UploadDao;
import com.example.Action.Entity.Upload;
import com.example.Action.Entity.UploadFile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {

    private final UploadDao uploadDao;

    public UploadService(UploadDao uploadDao) {
        this.uploadDao = uploadDao;
    }


//    public Map<String, Object> addUpload(MultipartFile file, Upload upload) {
//        Upload upload1 = uploadDao.addUpload(file,upload);
//        return Map.of(
//                "status", HttpStatus.CREATED.value(),
//                "message","successfully created",
//                "data",upload1
//
//        );
//    }

    public Map<String, Object> addUpload(Upload upload) {
        Upload upload1 = uploadDao.addUpload(upload);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "message", "successfully created",
                "data", upload1
        );
    }

    // Service method to handle uploading file content
    public Map<String, Object> uploadFile(MultipartFile file,Long uploadFileId) throws IOException {
        UploadFile uploadFile1 = uploadDao.uploadFile(file,uploadFileId);
        return Map.of(
                "status", HttpStatus.CREATED.value(),
                "message", "file content uploaded successfully",
                "data", uploadFile1
        );
    }


    public Map<String, Object> deleteUpload(Long uploadId, Long caseRefNo) {

        Long uploadFileId = uploadDao.getUploadFileId(uploadId, caseRefNo);

        if (uploadFileId != null) {
            // Delete from the upload table
            uploadDao.deleteFromUpload(uploadId, caseRefNo);

            // Delete from the uploadFile table
            uploadDao.deleteFromUploadFile(uploadFileId);
        } else {
            throw new RuntimeException("No matching records found.");
        }
        return Map.of(
               "status", HttpStatus.CREATED.value(),
                "message", "deleted successfully",
                "data","deleted"
       );

    }
}

