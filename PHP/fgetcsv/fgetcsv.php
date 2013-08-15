<?php
    //Open data.csv
    $file = fopen("data.csv", "r");

    //Read data until end
    while (!feof($file)) {
        $row = fgetcsv($file);
        print_r($row);
    }

    //Close file
    fclose($file);
