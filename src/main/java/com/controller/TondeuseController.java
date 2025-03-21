package com.controller;

import com.model.Pelouse;
import com.model.Tondeuse;
import com.service.TondeuseService;
import com.utils.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tondeuse")
public class TondeuseController {

    @Autowired
    private TondeuseService tondeuseService;

    @PostMapping("/process")
    public List<String> processTondeuses(@RequestParam("file") MultipartFile file) {
        try {
            // Parse the input file
            Map<String, Object> parsedData = FileParser.parseInputFile(file);

            Pelouse pelouse = (Pelouse) parsedData.get("pelouse");
            List<Tondeuse> tondeuses = (List<Tondeuse>) parsedData.get("tondeuses");
            List<String> commands = (List<String>) parsedData.get("commands");

            // Process each tondeuse with its respective commands
            List<String> results = new ArrayList<>();
            for (int i = 0; i < tondeuses.size(); i++) {
                Tondeuse tondeuse = tondeuses.get(i);
                String command = commands.get(i);
                String result = tondeuseService.processCommands(pelouse, tondeuse, command);
                results.add(result);
            }

            return results;
        } catch (Exception e) {
            throw new RuntimeException("Error processing the file: " + e.getMessage());
        }
    }
}
