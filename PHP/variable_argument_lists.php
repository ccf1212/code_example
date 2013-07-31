<?php
//Function Define
function num_args() {
    $num = func_num_args();
    return $num;
}

function print_args() {
    $num = func_num_args();
    for ($i = 0; $i < $num; $i++) {
        echo "$i:" .  func_get_arg($i) . "\n";
    }
}

//Function Test
echo num_args(1, 2, 3, 4, 5) . "\n";    //Print number of arguments
print_args("Hello", "World", "Guys");   //Print each argument

