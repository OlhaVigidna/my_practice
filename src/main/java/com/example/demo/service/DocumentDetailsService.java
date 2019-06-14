package com.example.demo.service;


import com.example.demo.dao.DocumentDetailsDAO;
import com.example.demo.models.DocumentDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class DocumentDetailsService {

    private DocumentDetailsDAO detailsDAO;

    public void saveDetails(MultipartFile file, DocumentDetails details) throws IOException {

        String filePath = System.getProperty("user.home") + File.separator + "savedFromMyPracticeDocuments" + File.separator;

        String fileType = splitFileType(file.getContentType());
        String fileName = parseName(file.getOriginalFilename());

        details.setSize(file.getBytes().length);
        details.setType(file.getContentType());
        details.setDocumentName(fileName);
        details.setType(fileType);
        details.setPath(filePath);

        detailsDAO.save(details);


        System.out.println(details);

        saveFile(file, details);

//        file.transferTo(Paths.get(pathCurrent + details.getDocumentName() + "." + details.getType()));
    }

    public List<DocumentDetails> findAll(){
        return detailsDAO.findAll();
    }

    private void saveFile(MultipartFile file, DocumentDetails details) throws IOException {
//                file.transferTo(Paths.get(pathCurrent + details.getDocumentName() + "." + details.getType()));
        file.transferTo(new File(details.getPath() + details.getDocumentName() + "." + details.getType()));

    }

    private String parseName(String fileName) {
        String[] names = fileName.split("\\.");
        return names[0];
    }

    private String splitFileType(String fileType) {
        String[] types = fileType.split("/");

        return types[types.length - 1];
    }


}
