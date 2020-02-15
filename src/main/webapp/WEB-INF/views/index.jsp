<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- GLOBAL HEADER -->
<jsp:include page="common/header.jsp"/>


<!-- COURSE COVER IMAGE -->

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <%-- 	<img src="${pageContext.request.contextPath }/images/course_cover.jpg"
        height="500px" class="w-100" />
 --%>
    <div id="carouselExampleControls" class="carousel slide mt-3"
         data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100 rounded" height="500px"
                     src="${pageContext.request.contextPath }/images/course_cover.jpg"
                     alt="First slide">
            </div>
            <div class="carousel-item rounded">
                <img class="d-block w-100" height="500px"
                     src="${pageContext.request.contextPath }/images/course_cover.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item rounded">
                <img class="d-block w-100" height="500px"
                     src="${pageContext.request.contextPath }/images/course_cover.jpg"
                     alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls"
           role="button" data-slide="prev"> <span
                class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                class="sr-only">Previous</span>
        </a> <a class="carousel-control-next" href="#carouselExampleControls"
                role="button" data-slide="next"> <span
            class="carousel-control-next-icon" aria-hidden="true"></span> <span
            class="sr-only">Next</span>
    </a>
    </div>


    <div class="row">

        <!-- HOMEWORK COLUMN-->
        <!--
		<div class="col">
			<h3 class="p-3">Homework</h3>

			<div class="row">
				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Countries</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/country/add"
									role="button">ADD</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/country/show-all" role="button">SHOW ALL</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Students</h4>
							<p class="card-text">
								<a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath }/student/add"
									role="button">ADD</a> <a
									class="btn btn-primary btn-lg btn-block"
									href="${pageContext.request.contextPath }/student/show-all" role="button">SHOW ALL</a>
							</p>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="card mb-2">
						<div class="card-body">
							<h4 class="card-title pb-3">Courses</h4>
							<p class="card-text">
							<form action="course/search" class="mb-5">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="Course Name" name="name">
								</div>
								<button type="submit" class="btn btn-primary  btn-lg btn-block">SEARCH</button>
							</form>


							<a class="btn btn-success btn-lg btn-block" href="course/add"
								role="button">ADD</a> <a
								class="btn btn-primary btn-lg btn-block" href="course/show-all"
								role="button">SHOW ALL</a>
							</p>
						</div>
					</div>
				</div>

			</div>

		</div>
-->
        <!-- COURSE OUTLINE COLUMN -->
        <div class="col">
            <div class="text-center mt-3 mb-3">
                <h3>
                    <small class="text-secondary">Course Title</small>
                </h3>
                <h3>Spring By Practical Examples</h3>
                <div class="row">
                    <div class="col">
                        <h3>
                            <small class="text-secondary">Instructor</small> <br> Syed
                            Mainul Hasan
                        </h3>
                    </div>
                    <div class="col">
                        <h3>
                            <small class="text-secondary">Duration</small> <br> 3 Months
                        </h3>
                    </div>
                </div>
                <h3>
                    <small class="text-secondary">Course Modules</small>
                </h3>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">01</h1>
                                    <span class="badge badge-success">Completed</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Environment setup (4 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Installing and configuring Java 11</li>
                                        <li>Installing and configuring Maven (Build tool)</li>
                                        <li>Installing Git (Version Control tool)</li>
                                        <li>Installing Intellij Idea (IDE)</li>
                                        <li>Introducing common git commands (if needed)</li>
                                        <li>Introduction to Maven</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">02</h1>
                                    <span class="badge badge-success">Completed</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Introduction to Servlet and JSP (4
                                        Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Introduction to Servlet and Servlet Container</li>
                                        <li>Configuring Servlet Application</li>
                                        <li>MVC architecture in Spring</li>
                                        <li>Implementing HttpServlet and working with different
                                            HTTP Methods
                                        </li>
                                        <li>View rendering with Servlet and JSP</li>
                                        <li>Simple form data handling with Servlet and JSP</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">03</h1>
                                    <span class="badge badge-success">Completed</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Spring HelloWorld Application (4
                                        Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Downloading application server (Tomcat)</li>
                                        <li>Configuring tomcat server with Intellij Idea</li>
                                        <li>MVC architecture in Spring</li>
                                        <li>Introduction to Servlet & Dispatcher Servlet
                                            Configuration
                                        </li>
                                        <li>What is a Bean, how to work with it</li>
                                        <li>View Resolver Bean definition, working with different
                                            view resolvers.
                                        </li>
                                        <li>@Component and @Configuration annotations</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">04</h1>
                                    <span class="badge badge-success">Completed</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Accessing Form Data with Spring (4
                                        Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Introduction to Taglibs.</li>
                                        <li>Form Taglib, core Taglib, and other taglib examples</li>
                                        <li>Accessing the form data and rendering those data to
                                            page
                                        </li>
                                        <li>Storing the form data in a list based storage,
                                            rendering them in the page
                                        </li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">05</h1>
                                    <span class="badge badge-success">Completed</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Integrating a UI Template (4 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Configuration to render Static contents</li>
                                        <li>Adding CSS, JS, images and other static contents</li>
                                        <li>Collecting data from Form and Rendering them into a
                                            page
                                        </li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">06</h1>
                                    <span class="badge badge-info">Ongoing</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Making a simple CRUD (4 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Installing Postgresql locally</li>
                                        <li>Integrating JDBC Template to make a CRUD (Connecting
                                            with a PSql DB)
                                        </li>
                                        <li>Opening a Heroku account and creating a Postgresql DB
                                            in Heroku
                                        </li>
                                        <li>Setting up different profiles (Dev, QA, Prod etc)</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">07</h1>
                                    <span class="badge badge-info">Ongoing</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Making advanced CRUD (8 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Integrating and configuring Hibernate Session
                                            Factory, Transaction Managers etc.
                                        </li>
                                        <li>Performing the CRUD with Hibernate</li>
                                        <li>Using Criteria API</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">08</h1>
                                    <span class="badge badge-secondary">Awaiting</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Applying basic security (4 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Integrating and Configuring Spring security</li>
                                        <li>Discussing Role Based Access Control feature (RBAC)
                                            in Spring framework
                                        </li>
                                        <li>Configuring Login, Log Out, default error pages</li>
                                        <li>Integrating custom filter and custom interceptor with
                                            spring security
                                        </li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">09</h1>
                                    <span class="badge badge-secondary">Awaiting</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Applying advanced security (4 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Defining Custom Authentication Provider</li>
                                        <li>Defining Custom Authentication Success handler,
                                            Custom Logout handler
                                        </li>
                                        <li>Using Password encryption algorithms</li>
                                        <li>Role Based Menu access handling</li>
                                        <li>Practice</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">10</h1>
                                    <span class="badge badge-secondary">Awaiting</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">Project deployment to Heroku (4
                                        Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Configuring heroku deployment environment</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-1">
                                    <h1 class="text-center">11</h1>
                                    <span class="badge badge-secondary">Awaiting</span>
                                </div>
                                <div class="col-sm-11">
                                    <h5 class="card-title">A template integrated web project
                                        development by participants (1) (8 Hrs)</h5>
                                    <p class="card-text">
                                    <ol>
                                        <li>Grooming, development and evaluation</li>
                                    </ol>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp"/>