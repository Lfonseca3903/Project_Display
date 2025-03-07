@extends('layouts.layout_master')
@section('content')
<br><br><br><br><br>
    <div class="container d-flex justify-content-center align-items-center full-height">
        <h1 id="homepageMessage">Bem vindo à página incial!</h1>
    </div>
    <br>
    <div class="container d-flex justify-content-center full-height">
        <ul><b>{{$cesaeInfo['name']}}</b></ul>
        <ul><b>{{$cesaeInfo['address']}}</b></ul>
        <ul><b>{{$cesaeInfo['email']}}</b></ul>
    </div>
@endsection
