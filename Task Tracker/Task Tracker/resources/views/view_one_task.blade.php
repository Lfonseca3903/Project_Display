@extends('layouts.layout_master')
@section('content')
<table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <td>{{$task->id}}</td>
    </tr>
    <tr>
        <th scope="col">Pessoa responsável</th>
        <td>{{$task->name}}</td>
    </tr>
    <tr>
        <th scope="col">Descrição</th>
        <td>{{$task->description}}</td>
    </tr>
    <tr>
        <th scope="col">Data de conclusão</th>
        <td>{{$task->due_at}}</td>
    </tr>
    <tr>
        <th scope="col">Estado</th>
        <td>{{$task->taskStatus}}</td>
    </tr>
      </tr>
    </thead>
  </table>
@endsection
