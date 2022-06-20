package services;

import dao.ScheduleDAO;
import models.Schedule;
import utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ScheduleService {
    private final ScheduleDAO dao;
    private LocalDate currentDate;
    private List<Schedule> selectWeek;

    public ScheduleService() {
        this.dao =  new ScheduleDAO();
        this.currentDate = LocalDate.now();
        this.selectWeek = new ArrayList<>();
    }

    public List<Schedule> getCurrentWeek() {
        currentDate = DateUtils.getBeginOfWeek(currentDate);
        selectWeek = dao.getWeek(currentDate);
        Collections.sort(selectWeek);
        return selectWeek;
    }

    public List<Schedule> getLastWeek() {
        currentDate = DateUtils.getLastMonday(currentDate);
        selectWeek = dao.getWeek(currentDate);
        Collections.sort(selectWeek);
        return selectWeek;
    }

    public List<Schedule> getNextWeek() {
        currentDate = DateUtils.getNextMonday(currentDate);
        selectWeek = dao.getWeek(currentDate);
        Collections.sort(selectWeek);
        return selectWeek;
    }

    public List<HashMap<int, String>> getAllDoOfWeek() {
        List<HashMap<int, String>> list = new ArrayList<>();
        getCurrentWeek();
    }

    public void setCurrentDate() {
        currentDate = LocalDate.now();
    }




}
