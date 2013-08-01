<?php
//declare a array $arr
$arr = array(
    'a' => 'apple',
    'b' => 'boy',
    'c' => 'cat',
    'd' => 'dog',
);

//value 'dog' exists in $arr, it returns the key 'd'
$key = array_search('dog', $arr);
echo $key . "\n";

//value 'Hello' does not exist in $arr, it returns false
$key = array_search('Hello', $arr);
echo $key . "\n";

if ($key === false)
    echo "true";
else
    echo "false";
