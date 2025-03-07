<?php

use App\Http\Controllers\PrendaController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\TaskControllerr;


Route::get('/', [UserController::class, 'home'])->name('home');

Route::get('/add-users', [UserController::class, 'addUsers'])->name('addUsers');

Route::post('/add-user', [UserController::class, 'addUser'])->name('addUser');

Route::get('/all-users', [UserController::class, 'allUsers'])->name('allUsers');

Route::get('/view/{id}', [UserController::class, 'viewOneUser'])->name('viewOneUser');

Route::get('/delete-users{id}', [UserController::class, 'deleteOneUser'])->name('deleteOneUser');

Route::get('/all-tasks', [TaskControllerr::class, 'allTasks'])->name('allTasks');

Route::get('/add-tasks', [TaskControllerr::class, 'addTasks'])->name('addTasks');

Route::post('/add-task', [TaskControllerr::class, 'addTask'])->name('addTask');

Route::get('/task/{id}', [TaskControllerr::class, 'viewOneTask'])->name('viewOneTask');

Route::get('/delete-tasks{id}', [TaskControllerr::class, 'deleteOneTask'])->name('deleteOneTask');


