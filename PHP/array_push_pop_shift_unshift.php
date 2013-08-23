<?php

//initial a array with one two three
$array = array('one', 'two', 'three');

//add four and five at the back of array
array_push($array, 'four', 'five');

print_r($array);

//pop the last element of array
$i_am_five = array_pop($array);

echo "I am five: $i_am_five\n";

//insert zero before the first element
array_unshift($array, 'zero');

print_r($array);

//remove the first element
array_shift($array);

print_r($array);
