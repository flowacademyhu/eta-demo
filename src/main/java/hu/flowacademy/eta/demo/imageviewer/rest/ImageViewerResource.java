package hu.flowacademy.eta.demo.imageviewer.rest;

import hu.flowacademy.eta.demo.imageviewer.service.ImageViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageViewerResource {

    @Autowired
    private ImageViewerService service;

    @GetMapping("/image")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        service.upload(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/image/download/{name}")
    public ResponseEntity<byte[]> upload(@PathVariable String name) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("content-type", service.contentType.get(name));
        return new ResponseEntity<>(service.download(name), headers, HttpStatus.OK);
    }

}
