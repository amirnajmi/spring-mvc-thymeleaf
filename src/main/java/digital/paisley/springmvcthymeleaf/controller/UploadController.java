package digital.paisley.springmvcthymeleaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    private final Map<String, Object> result = new HashMap<>();

    /// Receive message
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public void upload(@RequestParam("attach") MultipartFile file) throws IOException {
        // File info
        System.out.println("File name = "  + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        // Save to disk
        // file path example 1) Windows c:/, 3) Mac ~/Documents/
        String filePath = "D:/";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success", true);
//        return result;
    }

}
