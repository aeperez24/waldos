package com.syzo.waldos.controller;


import com.syzo.waldos.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WaldoGeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @ResponseBody()
    @RequestMapping(value = "generate",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> generar(){

        int row =10;
        int width=2000;
        byte[] result=generatorService.generate(row,width);
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=waldo.jpg");
        ResponseEntity<byte[]> response= new ResponseEntity<>(result, headers, HttpStatus.OK);
        return response;
    }

    @ResponseBody()
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloWorld(){

        return  "hello";
    }


}
