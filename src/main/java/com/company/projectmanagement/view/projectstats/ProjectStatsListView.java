package com.company.projectmanagement.view.projectstats;

import com.company.projectmanagement.app.ProjectStatsService;
import com.company.projectmanagement.entity.ProjectStats;
import com.company.projectmanagement.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Route(value = "projectStatses", layout = MainView.class)
@ViewController("ProjectStats.list")
@ViewDescriptor("project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
public class ProjectStatsListView extends StandardListView<ProjectStats> {

    @Autowired
    private ProjectStatsService projectStatsService;

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    protected List<ProjectStats> projectStatsesDlLoadDelegate(LoadContext<ProjectStats> loadContext) {
        // Here you can load entities from an external storage.
        // Set the loaded entities to the not-new state using EntityStates.setNew(entity, false).
        return projectStatsService.fetchProjectStatistics();
    }
}
