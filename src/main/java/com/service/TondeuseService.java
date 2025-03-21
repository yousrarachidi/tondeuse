package com.service;

import com.model.Pelouse;
import com.model.Tondeuse;
import org.springframework.stereotype.Service;

@Service
public class TondeuseService {
    public String processCommands(Pelouse pelouse, Tondeuse tondeuse, String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'A': tondeuse.avancer(pelouse); break;
                case 'G': tondeuse.tournerGauche(); break;
                case 'D': tondeuse.tournerDroite(); break;
            }
        }
        return tondeuse.toString();
    }
}
