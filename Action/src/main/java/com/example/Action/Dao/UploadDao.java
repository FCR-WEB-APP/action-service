package com.example.Action.Dao;

import com.example.Action.Entity.Upload;
import com.example.Action.Entity.UploadFile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

@Repository
public class UploadDao {

    private final JdbcTemplate jdbcTemplate1;

    public UploadDao(@Qualifier("jdbcTemplate1") JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate1 = jdbcTemplate1;
    }


//    public Upload addUpload(MultipartFile file,Upload upload) {
//        LocalDateTime date = LocalDateTime.now();
//
//        try {
//
//            String fileName = file.getOriginalFilename();
//            String documentType = getFileExtension(fileName);
//            String docName = fileName;
//
//
//            // Convert file content to Base64 and decode back to byte array
//            String base64Content = Base64.getEncoder().encodeToString(file.getBytes());
//            //byte[] fileContentBytes = Base64.getDecoder().decode(base64Content);
//
//            String sql = "INSERT INTO upload (case_Ref_No, document_Type, doc_Name, file_Content, case_Details_Type, head_Of_Fcr, credit_Reviewer_spoc, created_Date, updated_Date) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//            jdbcTemplate1.update(sql,
//                    upload.getCaseRefNo(),
//                    documentType,
//                    docName,
//                    base64Content,
//                    upload.getCaseDetailsType(),
//                    upload.getHeadOfFcr(),
//                    upload.getCreditReviewerSpoc(),
//                    date,date
//            );
//        } catch (Exception e) {
//            throw new RuntimeException("Error while processing file: " + e.getMessage(), e);
//        }
//        return upload;
//    }


    public Upload addUpload(Upload upload) {
        LocalDateTime date = LocalDateTime.now();


       String sql =  "INSERT INTO upload (upload_Id, case_Ref_No,upload_File_Id, document_Type, doc_Name,  sr_Credit_Reviewer, issue_Details, obligour, created_Date, updated_Date)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        jdbcTemplate1.update(sql,
                    upload.getUploadId(),
                    upload.getCaseRefNo(),
                upload.getUploadFileId(),
                upload.getDocumentType(),
                    upload.getDocName(),
                    upload.getSrCreditReviewer(),
                    upload.getIssueDetails(),
                    upload.getObligour(),
                    date,date
            );

        return upload;
    }



    public UploadFile uploadFile(MultipartFile file,Long uploadFileId) throws IOException {

        String base64Content = Base64.getEncoder().encodeToString(file.getBytes());
        byte[] fileContentBytes = Base64.getDecoder().decode(base64Content);

        String filename = file.getOriginalFilename();

        String sql = "insert into uploadfile (upload_File_Id,file_Content,file_Name) VALUES (?,?,?)";
        jdbcTemplate1.update(sql, uploadFileId,fileContentBytes,filename);

        UploadFile uploadFile = new UploadFile();
        uploadFile.setUploadFileId(uploadFileId);
        uploadFile.setFileContent(fileContentBytes);
        uploadFile.setFileName(filename);
        return uploadFile;
    }



    public Long getUploadFileId(Long uploadId, Long caseRefNo) {
        String query = "SELECT upload_File_Id FROM upload WHERE upload_Id = ? AND case_Ref_No = ?";
        try {
            return jdbcTemplate1.queryForObject(query, new Object[]{uploadId, caseRefNo}, Long.class);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteFromUpload(Long uploadId, Long caseRefNo) {
        String query = "DELETE FROM upload WHERE upload_Id = ? AND case_Ref_No = ?";
        jdbcTemplate1.update(query, uploadId, caseRefNo);
    }

    public void deleteFromUploadFile(Long uploadFileId) {
        String query = "DELETE FROM uploadfile WHERE upload_File_Id = ?";
        jdbcTemplate1.update(query, uploadFileId);
    }
}
