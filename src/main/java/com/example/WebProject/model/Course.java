package com.example.WebProject.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = Calendar.getInstance().getTime();
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = Calendar.getInstance().getTime();
    @OneToMany(mappedBy = "course")
    private List<Module> module;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public List<Module> getModule() {
        return module;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }
}


//                    {
//                            if (this.state.editing === 0) {
//                            return <div className="container-fluid">
//<Link to={'/courseEditor/' + this.props.course.id}>{this.props.course.title}</Link>
//<Route path={'/courseEditor/:courseId'} component={CourseEditor}/>
//</div>
//        } else {
//        return <div className="container-fluid">
//<input onChange={this.formChanged} className="form-control" value={this.props.course.title}/>
//<i className="fas fa-plus-square"
//        onClick={() => {
//        this.courseService.updateCourse(this.state.newCourse);
//        this.setState({editing: 0})
//        }
//        }/>
//</div>
//        }
//        }



//<div className="container-fluid">
//<input onChange={this.formChanged} className="form-control" value={this.props.course.title}/>
//<i className="fas fa-plus-square"
//        onClick={() => {
//        this.courseService.updateCourse(this.state.newCourse);
//        this.setState({editing: 0})
//        }
//        }/>
//</div>