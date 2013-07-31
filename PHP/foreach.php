<?php
//declare an array
$welcome = array(
    'title' => 'Hello',
    'visitor' => 50,
    'place' => 'HOME',
    'somke' => 'Yes',
);
//Example1:Print every value
foreach ($welcome as $value) {
    echo "$value\n";
}

//Example2:Print every key and value
foreach ($welcome as $key => $value) {
    echo "$key:$value\n";
}
