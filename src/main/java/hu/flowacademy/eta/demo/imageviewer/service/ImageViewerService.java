package hu.flowacademy.eta.demo.imageviewer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ImageViewerService {

    @Value("${base.folder.path}")
    private String baseFolderPath;

    public Map<String, String> contentType = new HashMap<>();

    public void upload(MultipartFile file) {
        try {
            contentType.put(file.getOriginalFilename(), file.getContentType());
            file.transferTo(new File(String.format(baseFolderPath + "%s", file.getOriginalFilename())));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public byte[] download(String name) {
        try {
            Path path = Paths.get(String.format(baseFolderPath + "%s", name));
            return Files.readAllBytes(path);
        } catch (IOException e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
