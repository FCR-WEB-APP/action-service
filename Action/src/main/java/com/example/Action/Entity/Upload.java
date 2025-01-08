package com.example.Action.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Upload {
    private Long uploadId;
    private String caseRefNo;
    private Long uploadFileId;
    private String documentType;
    private String docName;
  //  private byte[] fileContent; // Store as byte array
   // private String fileContent;
    private Long srCreditReviewer;
    private Long issueDetails;
    private Long obligour;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    // Getters and Setters


    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getCaseRefNo() {
        return caseRefNo;
    }

    public void setCaseRefNo(String caseRefNo) {
        this.caseRefNo = caseRefNo;
    }

    public Long getUploadFileId() {
        return uploadFileId;
    }

    public void setUploadFileId(Long uploadFileId) {
        this.uploadFileId = uploadFileId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

//    public byte[] getFileContent() {
//        return fileContent;
//    }
//
//    public void setFileContent(byte[] fileContent) {
//        this.fileContent = fileContent;
//    }


//    public String getFileContent() {
//        return fileContent;
//    }
//
//    public void setFileContent(String fileContent) {
//        this.fileContent = fileContent;
//    }


    public Long getSrCreditReviewer() {
        return srCreditReviewer;
    }

    public void setSrCreditReviewer(Long srCreditReviewer) {
        this.srCreditReviewer = srCreditReviewer;
    }

    public Long getIssueDetails() {
        return issueDetails;
    }

    public void setIssueDetails(Long issueDetails) {
        this.issueDetails = issueDetails;
    }

    public Long getObligour() {
        return obligour;
    }

    public void setObligour(Long obligour) {
        this.obligour = obligour;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
