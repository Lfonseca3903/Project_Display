<?php

namespace App\Http\Controllers;

use App\Models\Task;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Foundation\Auth\User;

class TaskControllerr extends Controller
{

    public function allTasks()
    {
        $results = DB::table('tasks')
            ->leftJoin('users', 'users.id', '=', 'tasks.user_id')
            ->select('tasks.id', 'users.name', 'tasks.description', 'tasks.due_at', 'tasks.status')
            ->get();
        foreach ($results as $item) {
            if ($item->status == 1) {
                $item->taskStatus = 'Tarefa completa';
            } else if ($item->status == 0) {
                $item->taskStatus = 'Tarefa incompleta';
            } else {
                $item->taskStatus = 'N/A';
            }
        }
        return view('all_tasks', compact('results'));
    }

    protected function getAllTasks()
    {

        $tasks = DB::table('tasks')->get();
        return $tasks;
    }

    public function addTasks() {
        $checkbox = true;
        $users = DB::table('users')->select('name')->get();
        return view('add_tasks', compact('checkbox', 'users'));
    }


    public function addTask(Request $request)

    {
        $request->validate([
            'description' => 'required|min:6|string',
            'due_at' => 'required|date',
            'user' => 'required|string'
        ]);

        $user = $request->user;
        $user_id = DB::table('users')->where('name', $user)->value('id');

        if($request->status == true) {
            $status = 1;
        } else {
            $status = 0;
        }

        Task::insert([
            'name' => $user,
            'description' => $request->description,
            'due_at' => $request->due_at,
            'user_id' => $user_id,
            'status' => $status
        ]);


        return redirect()->route('addTasks')->with('message', 'Tarefa adicionada com sucesso');
    }

    public function viewOneTask($id) {
        $task = DB::table('tasks')->where('id', $id)->first();
        if ($task->status == true) {
            $task->taskStatus = 'Tarefa completa';
        } else {
            $task->taskStatus = 'Tarefa incompleta';
        }
        return view('view_one_task', compact('task'));
    }

    public function deleteOneTask($id) {
        DB::table('tasks')->where('id', $id)->delete();
        return back();
    }
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
