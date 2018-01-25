<?php
require 'db_handler.php';
require 'vendor/autoload.php';
$app=new \Slim\App;

/**
* Get all Movies
*/
$app->get('/movies/',
function(){
$response=array();
$db=new DbHandler();
$result=$db->getAllMovies();
if($result != NULL){
$response['error']=false;
$response['movies']=array();
while($movie=$result->fetch_assoc()){
$tmp=array();
$tmp['ID']=$movie['ID'];
$tmp['MovieId']=$movie['MovieId'];
$tmp['Title']=$movie['Title'];
$tmp['VoteCnt']=$movie['VoteCnt'];
$tmp['VoteAvg']=$movie['VoteAvg'];
$tmp['Poster']=$movie['Poster'];
$tmp['Overview']=$movie['Overview'];
$tmp['ReleaseDay']=$movie['ReleaseDay'];
array_push($response['movies'],$tmp);
}
echo json_encode($response);
}
else {
$response ['error']=true;
$response ['message']="There is no movie in database";
echo json_encode($response);
}
$db->Close();
}
);

/**
* Get Single Movie
*/
$app->get('/movies/id/{mid}',
function($request,$response,$args){
$response=array();
$db=new DbHandler();
$result=$db->getMovieById($args['mid']);
if($result != NULL){
$response['error']=false ;
$response['ID']=$result['ID'];
$response['MovieId']=$result['MovieId'];
$response['Title']=$result['Title'];
$response['VoteCnt']=$result['VoteCnt'];
$response['VoteAvg']=$result['VoteAvg'];
$response['Poster']=$result['Poster'];
$response['Overview']=$result['Overview'];
$response['ReleaseDay']=$result['ReleaseDay'];
echo json_encode($response);
}
else{
$response['error']=true ;
$response['message']="There is no requested movie in database";
echo json_encode($response);
}
$db->Close() ;
}
);

/**
* Get ( no arguments / patterns / segments )
*/
$app->get('/',
function(){
echo '<h1> Android Programming </h1><br><br>';
echo '<form action ="/post" method="post">';
echo '<label>First Name: </label>';
echo '<input name="first" type="text"/><br>';
echo '<label>Last Name:</label>';
echo '<input name="last" type="text"/><br>';
echo '<input type="submit" value="Submit"/>';
echo '</form>';
}
);
/**
* POST
*/
$app->post('/post',
function($request,$response,$args){
echo "This is a POST route.<br>";
$data=$request->getParsedBody();
echo $data['first']."<br>";
echo $data['last'];
}
);

$app->get('/add',
function(){
echo '<h1> Inserting New Movie </h1><br><br>';
echo '<form action ="http://hdahagam.com/app7/addnewmovie" method="post">';
echo '<label>Movie ID: </label>';
echo '<input name="movieid" type="text"/><br>';
echo '<label>Title:</label>';
echo '<input name="title" type="text"/><br>';
echo '<label>Vote Count:</label>';
echo '<input name="votecount" type="text"/><br>';
echo '<label>Vote Average:</label>';
echo '<input name="voteavg" type="text"/><br>';
echo '<label>Poster Path:</label>';
echo '<input name="poster" type="text"/><br>';
echo '<label>Overview:</label>';
echo '<input name="overview" type="text"/><br>';
echo '<label>Release Date:</label>';
echo '<input name="release" type="text"/><br>';
echo '<input type="submit" value="Submit"/></tr>';
echo '</form>';
}
);

$app->get('/movies/rating/{rid}',
function($request,$response,$args){
$response=array();
$db=new DbHandler();
$result=$db->getMoviesByRating($args['rid']);
if($result != NULL){
$response['error']=false;
$response['movies']=array();
while($movie=$result->fetch_assoc()){
$tmp=array();
$tmp['ID']=$movie['ID'];
$tmp['MovieId']=$movie['MovieId'];
$tmp['Title']=$movie['Title'];
$tmp['VoteCnt']=$movie['VoteCnt'];
$tmp['VoteAvg']=$movie['VoteAvg'];
$tmp['Poster']=$movie['Poster'];
$tmp['Overview']=$movie['Overview'];
$tmp['ReleaseDay']=$movie['ReleaseDay'];
array_push($response['movies'],$tmp);
}
echo json_encode($response);
}
else {
$response ['error']=true;
$response ['message']="Sorry !!! There is no movie";
echo json_encode($response);
}
$db->Close() ;
}
);

$app->post('/addnewmovie',
function($request,$response,$args){
$data=$request->getParsedBody();
$db=new DbHandler();
$result=$db->addNewMovie($data['movieid'], $data['title'], $data['votecount'], $data['voteavg'], $data['poster'], $data['overview'], $data['release']);
if($result)
{
	echo "Movie INSERTED";
}
else{
	echo "Movie FAILED to INSERT";
}
}
);

/**
* Deleting movie
*/
$app->get('/delete/id/{mid}',
function($request,$response,$args){
	$movieid=$args['mid'];
echo '<form action ="http://hdahagam.com/app7/delete" method="post">';
echo '<input type="text" name="mid" value=';
echo $movieid;
ECHO ' />';
echo "<h1> Are you sure you want to delete the movie ??? </h1><br>";
echo '<input type="submit" value="Confirm"/>';
echo '</form>';
}
);

$app->post('/delete',
function($request,$response,$args){
$data=$request->getParsedBody();
$db=new DbHandler();
$result=$db->deleteMovieById($data['mid']);
if($result)
{
	echo "Movie DELETED";
}
else{
	echo "Movie DELETION FAILED";
}
}
);

// Run the Slim Application
$app->run();
?>