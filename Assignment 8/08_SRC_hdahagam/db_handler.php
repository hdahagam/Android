<?php
/**
* Class to handle all db operations
*/
class DbHandler{
private $conn;
function __construct(){
require_once dirname(__FILE__).'/db_connect.php';
//opening db connection
$db=new DbConnect();
$this->conn=$db->connect();
}
public function Close(){
$this->conn->close();
}
public function getAllMovies(){
$stmt=$this->conn->prepare("SELECT * FROM Movies");
if($stmt->execute())
{
$movies=$stmt->get_result();
$stmt->close();
}else{
	return NULL;
}
return $movies ;
}
public function getMovieById($mid)
{
$stmt=$this->conn->prepare("SELECT * FROM Movies WHERE id = ?");
$stmt->bind_param("s",$mid);
if($stmt->execute()){
$movie=$stmt->get_result()->fetch_assoc();
$stmt->close();
return $movie;
}else{
return NULL;
}
}

public function addNewMovie($mid, $title, $votecnt, $voteavg, $poster, $overview, $release){
$stmt=$this->conn->prepare("INSERT INTO Movies(MovieId, Title, VoteCnt, VoteAvg, Poster, Overview, ReleaseDay) VALUES(?,?,?,?,?,?,?)");
$stmt->bind_param("sssssss",$mid, $title, $votecnt, $voteavg, $poster, $overview, $release);
if($stmt->execute())
{
$movies=$stmt->get_result();
$stmt->close();
return true;
}else{
	return false;
}
}

public function getMoviesByRating($rtng){
$stmt=$this->conn->prepare("SELECT * FROM movies WHERE VoteAvg > ?");
$stmt->bind_param("s",$rtng);
if($stmt->execute())
{
$movies=$stmt->get_result();
$stmt->close();
return $movies;
}else{
	echo "No movies"; 
	return NULL;
}
}

public function deleteMovieById($movieid){
$stmt=$this->conn->prepare("DELETE FROM Movies WHERE id = ?");
$stmt->bind_param("s",$movieid);
if($stmt->execute())
{
$movies=$stmt->get_result();
$stmt->close();
return true;
}else{
	return false;
}
}
}
?>