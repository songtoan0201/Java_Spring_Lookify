package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;

	public SongController(SongService songService) {
		super();
		this.songService = songService;
	}

	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/views/dashboard.jsp";
	}

	@RequestMapping("/songs/new")
	public String newBook(@ModelAttribute("song") Song song) {
		return "/views/add.jsp";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/add.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/views/details.jsp";
	}

	@RequestMapping("/songs/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/views/edit.jsp";
	}

	@RequestMapping(value = "/songs/{id}", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/views/edit.jsp";
		} else {
			songService.updateSong(song.getId(), song.getTitle(), song.getArtist(), song.getRating());
			return "redirect:/dashboard";
		}
	}

	@RequestMapping(value = "/songs/{id}/delete", method = RequestMethod.POST)
	public String destroyPost(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/{id}/delete")
	public String destroyGet(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchArtist(@RequestParam("artist") String artist, Model model) {
		System.out.println(artist);
		
		return "redirect:/search/" + artist;

	}

	@RequestMapping("/search/{artist}")
	public String showArtist(@PathVariable("artist") String artist, Model model) {
		
		List<Song> songsByArtist = songService.searchArtist(artist);
		for(Song art: songsByArtist) {
			System.out.println(art.getArtist());
		}
		model.addAttribute("songsByArtist", songsByArtist);

//		model.addAttribute("songsByArtist", model.getAttribute("songsByArtist"));
		return "/views/search.jsp";
	}
	
	@RequestMapping("/search/topten")
	public String showTopTen(Model model) {
		List<Song> songs = songService.findTopTen();
		model.addAttribute("songs", songs);
		return "/views/topten.jsp";
	}
}
