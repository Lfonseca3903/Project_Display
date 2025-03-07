@extends('layouts.layout_master')
@section('content')
@if (session('message'))
<div class="alert alert-success">{{session('message')}}</div>
@endif
    <form method="POST" action="{{route('addUser')}}">
        @csrf
        <div class="form-group">
            <label for="addName">Nome</label>
            <input type="text" name="name" class="form-control" id="addName">
            @error('name')
            Nome inválido
            @enderror
        </div>
        <div class="form-group">
            <label for="addEmail">Email</label>
            <input type="email" name="email" class="form-control" id="addEmail">
        </div>
        @error('email')
            Email inválido
            @enderror
        <div class="form-group">
            <label for="addPassword">Palavra-passe</label>
            <input type="password" name="password" class="form-control" id="addPassword">
        </div>
        @error('password')
            Palavra-passe inválida
            @enderror
        <br>
        <button type="submit" class="btn btn-primary">Enviar</button>   <button type="clear" class="btn btn-primary">Limpar</button>
    </form>
@endsection
