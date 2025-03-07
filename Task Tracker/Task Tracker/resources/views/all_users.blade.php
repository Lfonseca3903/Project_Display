@extends('layouts.layout_master')
@section('content')
<table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Nome</th>
        <th scope="col">Email</th>
        <th scope="col">Mais opções</th>
      </tr>
    </thead>
    <tbody>
        @foreach ($users as $item)
      <tr>
        <th scope="row">{{$item -> id}}</th>
        <td>{{$item -> name}}</td>
        <td>{{$item -> email}}</td>
        <td><a class="btn btn-info" href={{route('viewOneUser', $item->id)}}>Ver</a>  <a class="btn btn-danger" href={{route('deleteOneUser', $item->id)}}>Apagar</a></td>
        @endforeach
      </tr>
    </tbody>
  </table>
@endsection


