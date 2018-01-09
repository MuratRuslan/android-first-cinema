package com.example.user.myapplication.dao.impl;


import com.example.user.myapplication.dao.Repository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class AbstractRepository<T> implements Repository<T> {

    protected String serviceUrl;

    protected String servicePath;

    protected URL url;

    protected HttpURLConnection connection;

    public AbstractRepository(String servicePath) {
        this.servicePath = servicePath;
        this.serviceUrl = Config.URL_API;
        try {
            this.url = new URL(serviceUrl + servicePath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<T> findAll() {
        Collection<T> collection = new ArrayList<>();
        T[] arr = null;
        try {
            initConnection("GET");
            String response = getResponse();
            Gson gson = new Gson();
            arr = gson.fromJson(response, (Class<T[]>) getArrayClassType());
        } catch (ProtocolException e) {

        } catch (MalformedURLException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return Arrays.asList(arr);
    }

    @Override
    public T findById(Integer id) {
        T res = null;
        try {
            initConnection("GET");
            String response = getResponse();
            Gson gson = new Gson();
            res = gson.fromJson(response, (Class<T>) getClassType());
        } catch (ProtocolException e) {

        } catch (MalformedURLException e) {

        } catch (IOException e) {

        } finally {
            connection.disconnect();
        }
        return res;
    }

    protected abstract Class getClassType();

    protected abstract Class getArrayClassType();

    protected void initConnection(String requestMethod) throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod(requestMethod);
    }

    protected String getResponse() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
