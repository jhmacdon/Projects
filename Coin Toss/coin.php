<?php

/*
A simple coin toss flipping simulator, because why not. 
(I was bored on the train, give me a break)

The function faced some error at 10,000,000 coins so I 
broke it up to sort of recursively call itself, though
its more of a psuedo recursion since it just passes its
values onto the next case of itself. 

Should work for up to 1,000,000,000,000,000 (or it may
timeout at 12000s, depends on your machine/time to waste)

NOT FULLY TESTED
My train got to its location before I was 100% done :)
*/

ini_set('display_errors', 1);
error_reporting(E_ALL);
set_time_limit (12000000);

$coin = false;
$heads = 0;
$tails = 0;
$num = 1000000;

if($num>10000000){
	$times = $num%100000000;
}
if(isset($_GET['times'])){
	$times = (int)$_GET['times'] - 1;
	$heads = (double)$_GET['heads'];
	$tails = (double)$_GET['tails'];
}



for($i=0;$i<$num;$i++){
	$val = rand(0,1);
	if($val%2 == 1){$coin = true;}
	else {$coin = false;
	}
	//echo "Coin #".(string)($i+1).":";
	if($coin){
		//echo "heads!";
		$heads++;	
	}
	else{//echo "tails!";
		$tails++;
	}
	//echo '<br>';
}


if(!isset($times)){
echo $heads . " total heads, ". $tails . " total tails";
?>
<br>
<input type="submit" onClick="(window.location='./coin.php')" value="Flip <?php echo $num; ?> coins!">
<br>
<?php }else if($times == 0){
echo $heads . " total heads, ". $tails . " total tails";
}else{
header('Location: coin.php?times='.$times.'&heads='.$heads.'&tails='.$tails);
}
