<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="GlobalConstant" class="org.animopts.bean.GlobalConstant" scope="session"/>
<template:browse-template pageTitle="Who are we?">
	<jsp:attribute name="body">
	
<legend align="center">WHO ARE WE?</legend>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-offset-3 col-sm-6">
            <div class="panel panel-default">
                <div class="panel-heading c-list">
                    <span class="title">Tutors</span>
                    <ul class="pull-right c-controls">
                        <li><a href="#" class="hide-search" data-command="toggle-search" data-toggle="tooltip" data-placement="top" title="Toggle Search"><i class="fa fa-ellipsis-v"></i></a></li>
                    </ul>
                </div>
                
                <div class="row" style="display: none;">
                    <div class="col-xs-12">
                        <div class="input-group c-search">
                            <input type="text" class="form-control" id="contact-list-search">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search text-muted"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
                
                <ul class="list-group" id="contact-list">
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <img src="<c:url value="${GlobalConstant.NO_AVATAR}" />" alt="Gaius Ambion" class="img-circle avatar-medium" />
                        </div>
                        <div class="col-xs-12 col-sm-9">
                            <span class="name">Gaius Ambion</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="COMPRO2"></span>
                            <span class="visible-xs"> <span class="text-muted">COMPRO2</span><br/></span>
                            <span class="fa fa-facebook text-muted c-info" data-toggle="tooltip" title="https://www.fb.com/gaambion"></span>
                            <span class="visible-xs"> <span class="text-muted"></span><br/></span>
                            <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title="gaius_ambion@dlsu.edu.ph"></span>
                            <span class="visible-xs"> <span class="text-muted">gaius_ambion@dlsu.edu.ph</span><br/></span>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <img src="<c:url value="${GlobalConstant.NO_AVATAR}" />" alt="Brandon Penaranda" class="img-circle avatar-medium" />
                        </div>
                        <div class="col-xs-12 col-sm-9">
                            <span class="name">Brandon Penaranda</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="COMPRO2"></span>
                            <span class="visible-xs"> <span class="text-muted">COMPRO2</span><br/></span>
                            <span class="fa fa-facebook text-muted c-info" data-toggle="tooltip" title="https://www.fb.com/BrandonUPenaranda"></span>
                            <span class="visible-xs"> <span class="text-muted"></span><br/></span>
                            <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title="brandon_penaranda@dlsu.edu.ph"></span>
                            <span class="visible-xs"> <span class="text-muted">brandon_penaranda@dlsu.edu.ph</span><br/></span>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <img src="<c:url value="${GlobalConstant.NO_AVATAR}" />" alt="Gelo Reamon" class="img-circle avatar-medium" />
                        </div>
                        <div class="col-xs-12 col-sm-9">
                            <span class="name">Gelo Reamon</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="COMPRO2"></span>
                            <span class="visible-xs"> <span class="text-muted">COMPRO2</span><br/></span>
                            <span class="fa fa-facebook text-muted c-info" data-toggle="tooltip" title="https://www.fb.com/gelo103097"></span>
                            <span class="visible-xs"> <span class="text-muted"></span><br/></span>
                            <span class="fa fa-comments text-muted c-info" data-toggle="tooltip" title="david_reamon@dlsu.edu.ph"></span>
                            <span class="visible-xs"> <span class="text-muted">david_reamon@dlsu.edu.ph</span><br/></span>
                        </div>
                        <div class="clearfix"></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</jsp:attribute>
</template:browse-template>