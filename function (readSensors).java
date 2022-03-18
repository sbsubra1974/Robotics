void function (readSensors)
{
    if (sensors == "00")
        {   
            action = "Stop";
            output = "left motor off && right motor off";
        }    
    else if (sensors == "10")
       {
           action = "Turn Left";
           output = "left motor forward at 75% && right motor forward at 25%";
           sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
       }
    else if (sensors == "01")
        {
            action = "Turn Right";
            output = "left motor forward at 25% && right motor forward at 75%";
            sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
        }
    else if (sensors == "11")
        {
            action = "Go Straight";
            output = "left motor forward at 75% && right motor forward at 75%";
            if (perception == "Object Found")
                {
                    action = "Inspect Object";
                    if (perception == "Obstacle detected || (Gripper is empty && Table Detected)")
                        {
                            action = ("Turn θ⁰ || Avoid Obstacle");
                            output = "left motor forward at 75% && right motor forward at 75%";
                            sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
                        } 
                    else if (perception == "Gripper is full && Table Detected)")
                        {
                            action = ("Drop Apple");
                            perception = "Gripper is empty";
                            output = "left motor forward at 75% && right motor forward at 75%";
                            sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
                        }
                    else if (perception == "Apple Detected && Gripper is empty") //check if gripper will always be empty
                        {
                            action = ("Grab Apple");
                            perception = "Gripper is full";
                            output = "left motor forward at 75% && right motor forward at 75%";
                            sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
                        }
                    else if (perception == "Apple Detected && Gripper is full") //check if gripper will always be empty
                        {
                            action = ("Turn θ⁰ || Avoid Obstacle");
                            output = "left motor forward at 75% && right motor forward at 75%";
                            sensors = "11"; //check if action:Go Straight has to be mentioned instead of sensors=11
                        }            
                }
             else
                {
                    perception = null;    
                }                   
        }   
}        

