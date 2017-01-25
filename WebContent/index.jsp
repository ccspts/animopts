<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<template:home-template pageTitle="Home">
	<jsp:attribute name="body">
	
<div id="intro" class="home parallax" data-image="./img/pts1.jpg">
    <div class="container">
    	<div class="col-lg-12 vertical-center">
			<h1>
				Animo PTS
			</h1>
			<h4 class="justified">
				Peer Tutors Society is a student organization from De La Salle University - College of 
				Computer Studies that aims to help students in their academic studies through tutoring.
			</h4>
    	</div>
    </div>
</div>
<!-- Request Tutor Section -->
<div class="home request-tutor-section" id="request-tutor">
    <div class="container">
        <div class="row">
            <div class="col-md-6 vertical-center">
                <h1>
                    Having difficulty in your studies?
                </h1>
                <h4 class="justified">
                    The Peer Tutors Society is an initiative under the Office of the College of Computer Studies
                    Vice Dean which aims to select, train, qualify and deploy a group of students in order to 
                    conduct individualized (one-on-one) or group tutoring sessions for students in various 
                    subjects. Any tutoring session will primarily be characterized by individualized 
                    instruction (explaining and / or reviewing constructs, discussing solutions to sample 
                    programs) and remediation (providing corrections, giving hints and / or advice, coaching).
                </h4>
                <button class="btn btn-primary" type="button">
                    Request a Tutor
                </button>
            </div>
            <div class="col-md-2">
            </div>
            <div class="col-md-4">
                <h1>
                    
                </h1>
            </div>
        </div>
    </div>
</div>


<div class="home parallax" data-image="./img/pts2.jpg">
    <div class="container">
    	<div class="col-lg-12 vertical-center">
			<h1>
				Inspire. Share. Grow.
			</h1>
    	</div>
    </div>
</div>

<!-- Apply as Tutor Section -->
<div class="home apply-tutor-section" id="apply-tutor">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h1>
                    
                </h1>
            </div>
            <div class="col-md-2">
            </div>
            <div class="col-md-6 vertical-center">
                <h1>
                    Want to be a Tutor?
                </h1>
                <h4 class="justified">
					Are you bored of just sitting around and doing nothing? Join PTS and make an impact in 
					this beautiful university. Not only will you be able to help
					others with their studies, it is also a great opportunity to make new friends. Join us now
					and unlock that potential that you have inside.
                </h4>
                <button class="btn btn-primary" type="button">
                    Apply Now
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Contact Section -->
<div id="contact" class="home parallax" data-image="./img/pts3.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 vertical-center">
                <h1>
                    Contact Us		
                </h1>
                <br>
                <h4 class="justified">
                	Never walk alone in your studies. Reach out to us on Facebook!
                </h4>
            </div>
        </div>
    </div>
</div>

	</jsp:attribute>
</template:home-template>