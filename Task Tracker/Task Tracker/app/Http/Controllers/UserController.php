<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Foundation\Auth\User;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    public function home() {

        $cesaeInfo = $this->getCesaeInfo();

        return view('home', compact('cesaeInfo'));
    }

    public function addUsers() {
        return view('add_users');
    }

    public function addUser(Request $request) {
        $request->validate([
            'name' => 'required|min:3|string',
            'email' => 'required|email|unique:users,email',
            'password' => 'required|min:8'
        ]);

        User::insert([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password)
        ]);
        return redirect()->route('addUsers')->with('message', 'Usuário adicionado com sucesso');
    }

    public function addUsersToDatabase() {
        DB::table('users')->insert([
            ['name' => 'Bob', 'email' => 'bob@gmail.com', 'password' => 'bob123'],
            ['name' => 'Carol', 'email' => 'carol@gmail.com', 'password' => 'carol456'],
            ['name' => 'Ted', 'email' => 'ted@gmail.com', 'password' => 'ted789']
        ]);
    }

    public function allUsers() {
        $users = DB::table('users')->get();
        return view('all_users', compact('users'));
    }

    public function getCesaeInfo() {

        $cesaeInfo = [
            'name' => 'Cesae',
            'address' => 'Rua Ciríaco Cardoso 186, 4150-212 Porto',
            'email' => 'cesae@cesae.pt'
            ];

        return $cesaeInfo;
    }

    public function viewOneUser($id) {
        $user = DB::table('users')->where('id', $id)->first();
        return view('view_one_user', compact('user'));
    }

    public function deleteOneUser($id) {
        DB::table('users')->where('id', $id)->delete();
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
