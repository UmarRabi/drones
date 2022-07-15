/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umar.drones.services;

//import org.jobrunr.autoconfigure.JobRunrProperties.JobScheduler;
//import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author the Rabbi
 */
@Service
public class JobService {
    
//        @Autowired
//        private JobScheduler jobScheduler;
        
        public void runJob(){
           
//           jobScheduler.scheduleRecurrently(Cron.every5minutes(), ()->System.out.println("Pringting jobs"));
        }
}
