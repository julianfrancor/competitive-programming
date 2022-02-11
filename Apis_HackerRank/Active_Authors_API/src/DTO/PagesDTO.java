package DTO;


import java.util.List;

public class PagesDTO {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<AuthorsDTO> data;
}