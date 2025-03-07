@extends('layouts.layout_master')
@section('content')
@if (session('message'))
<div class="alert alert-success">{{session('message')}}</div>
@endif
    <form method="POST" action="{{route('addTask')}}">
        @csrf
            <div class="form-group">
                <label>Pessoa responsável</label>
                <select name="user">
                    @foreach ($users as $item)
                    <option value={{$item->name}}>{{$item->name}}</option>
                    @endforeach
                  </select>
            </div>
        <div class="form-group">
            <label for="addDescription">Descrição</label>
            <input type="text" name="description" class="form-control" id="addDescription">
        </div>
        @error('description')
            Descrição inválida
        @enderror
        <div class="form-group">
            <label for="addDate">Data de conclusão</label>
            <input type="date" name="due_at" class="form-control" id="addDate">
        </div>
        @error('due_at')
            Data inválida
        @enderror
        <div>
            <br>
            <input type="checkbox" name="status" id="addStatus" {{$checkbox ? true : false}}><label for="addStatus">Tarefa completa?</label>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Enviar</button>   <button type="clear" class="btn btn-primary">Limpar</button>
    </form>
@endsection
