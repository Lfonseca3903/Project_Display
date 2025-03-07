@extends('layouts.layout_master')
@section('content')
<table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Nome</th>
        <th scope="col">Tarefa</th>
        <th scope="col">Data de conclusão</th>
        <th scope="col">Estado</th>
        <th scope="col">Mais opções</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
        @foreach ($results as $item)
      <tr>
        <th scope="row">{{$item -> id}}</th>
        <td>{{$item -> name}}</td>
        <td>{{$item -> description}}</td>
        <td>{{$item -> due_at}}</td>
        <td>{{$item -> taskStatus}}</td>
        <td><a class="btn btn-info" href={{route('viewOneTask', $item->id)}}>Ver</a>  <a class="btn btn-danger" href={{route('deleteOneTask', $item->id)}}>Apagar</a><td>
        @endforeach
      </tr>
    </tbody>
  </table>
@endsection
