package com.example.Action.Controller;

import com.example.Action.Entity.Upload;
import com.example.Action.Service.UploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api/upload")
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

//    @PostMapping("/add")
//    public ResponseEntity<Map<String,Object>> addupload(@RequestParam("file") MultipartFile file, @RequestParam("upload") String uploadJson){
//        try{
//            ObjectMapper objectMapper = new ObjectMapper();
//            Upload upload = objectMapper.readValue(uploadJson, Upload.class);
//
//            Map<String,Object> res = uploadService.addUpload(file,upload);
//            return new ResponseEntity<>(res, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(Map.of("message","something went wrong","error",e.getMessage()),HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>>addupload(@RequestBody Upload upload){
        try{
            Map<String,Object> res = uploadService.addUpload(upload);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message","something went wrong","error",e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/addFile/{upload_File_Id}")
    public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable("upload_File_Id") Long uploadFileId) {
        try {
            Map<String, Object> response = uploadService.uploadFile(file, uploadFileId);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Map.of("message", "Error occurred while uploading file", "error", e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }



    @DeleteMapping("/delete/{upload_Id}/{case_Ref_No}")
    public ResponseEntity<Map<String,Object>> deleteUpload(@PathVariable ("upload_Id") Long uploadId,
                                                           @PathVariable("case_Ref_No") Long caseRefNo){
        try{
            Map<String,Object> res = uploadService.deleteUpload(uploadId,caseRefNo);
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Map.of("message", "Error occurred while deleting ", "error", e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );

        }

    }
}
