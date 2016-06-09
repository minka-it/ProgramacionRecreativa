<?php
$x=20;
$n;
for ($i=1; $i<=$x; $i++){ 
 $n=30*(2*$i-27)*($i-15);
  if(!(primo($n-1)&&primo($n+1))){
    printf("$i \n");
  }
}
function primo($num) {
   $limite = sqrt($num);
     if (($num%2)==0 || $num<1) {
        return false;
     }else {
	for($i = 3; $i <= $limite; $i++) {
	     if($num % $i == 0) {
	       return FALSE;
	     }
	 }
     }
     return true;
}
?>
