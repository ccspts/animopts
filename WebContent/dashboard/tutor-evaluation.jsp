<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?php
include_once $_SERVER['DOCUMENT_ROOT']."/animopts/include/load.php";
$pageTitle = 'My Profile';
include ROOTPATH."include/header.php";
?>
<!-- Dashboard -->
<?php include ROOTPATH."include/core/dashboard/dashboard-header.php"; ?>
<!-- Registration Form -->
<div class="col-lg-12">
    <h1>Evaluate Tutor</h1>
    <div class="row">
        <div class="col-lg-6">
            <div class="col-lg-12 well">
                <div class="row">
                    <form>
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label>Name of tutor</label>
                                <div class="row">
                                    <div class="col-xs-6 col-md-6">
                                        <input type="text" placeholder="First" name="firstName" class="form-control">
                                    </div>
                                    <div class="col-xs-6 col-md-6">
                                        <input type="text" placeholder="Last" name="lastName" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Frequency</label>
                                <input type="text" placeholder="  Did you frequently had a session especially when you needed it?" name="frequency" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Preparedness</label>
                                <input type="text" placeholder="  How prepared was your tutor during sessions?" name="preparedness" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Explanation</label>
                                <input type="text" placeholder="   Does your tutor explain clearly and can easily be understood?" name="explanation" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Exercises</label>
                                <input type="text" placeholder="   Does your tutor provide sufficient exercises for you??" name="exercises" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Relevance</label>
                                <input type="text" placeholder="   Did your tutor teach topics that were relevant in your lessons and projects?" name="relevance" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Enthusiasm</label>
                                <input type="text" placeholder="   Did your tutor teach topics beyond the curriculum to further your learning?" name="enthusiasm" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Confidence</label>
                                <input type="text" placeholder="   Did your tutor exhibit confidence?" name="confidence" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Knowledgeable </label>
                                <input type="text" placeholder="   Is your tutor knowledgeable of the topic?" name="knowledgeable" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Vocal</label>
                                <input type="text" placeholder="   Is your tutor's voice clear and loud enough?" name="vocal" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Question & Answer</label>
                                <input type="text" placeholder="   Does your tutor respond quickly and appropriately when asked a question?" name="QA" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Effectiveness</label>
                                <input type="text" placeholder="   Is your tutor's method of teaching effective in your learning?" name="effectiveness" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Encouraging</label>
                                <input type="text" placeholder="   Is your tutor encouraging to do your best and is proud of your achievements?" name="encouraging" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <div class="form-group">
                                <label>Passion</label>
                                <input type="text" placeholder="   Is your tutor passionate in tutoring you?" name="passion" class="form-control">
                                <p class="small note">* Score from 1 to 10</p>
                            </div>
                            <br><br>
                            <div class="form-group">
                                <label>Personal Message</label>
                                <input type="text" placeholder="   Have something to say to your beautiful/pogi tutor??" name="pMsg" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Comments & Suggestion</label>
                                <input type="text" placeholder="   How can we improve our services to you?" name="cmnt" class="form-control">
                            </div>
                            <button type="button" class="btn btn-lg btn-info">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <?php include ROOTPATH."include/core/dashboard/dashboard-footer.php"; ?>
    <?php include ROOTPATH."include/core/footer.php"; ?>