@extends('layouts.layout_master')
@section('content')
<table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <td>{{$user->id}}</td>
    </tr>
    <tr>
        <th scope="col">Nome</th>
        <td>{{$user->name}}</td>
    </tr>
    <tr>
        <th scope="col">Email</th>
        <td>{{$user->email}}</td>
    </tr>
    <tr>
        <th scope="col">Palavra-passe</th>
        <td>{{$user->password}}</td>
    </tr>
      </tr>
    </thead>
  </table>
@endsection
