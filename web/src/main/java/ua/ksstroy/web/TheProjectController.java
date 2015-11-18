package ua.ksstroy.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.ksstroy.logic.zone.ZoneData;
import ua.ksstroy.logic.zone.ZoneHierarchyData;
import ua.ksstroy.logic.zone.ZoneManager;

@Controller
public class TheProjectController {

	@Resource(name = "ZoneManagerImpl")
	ZoneManager zoneManager;
	ModelAndView project;
	private final Logger logger = LoggerFactory.getLogger(WelcomeControllerForTest.class);
	
	@RequestMapping(value = "/projects/{projectId}", method = RequestMethod.GET)
	public ModelAndView showZHD(@PathVariable String projectId) {
		project = new ModelAndView("the_project");
		project.addObject("projectId", projectId);
		ZoneHierarchyData zhd = zoneManager.getRootZoneHierarchy(projectId);
		project.addObject("rootGroupId", zhd.getId());
		project.addObject("zhd", zhd);
		return project;
	}

	@RequestMapping(value = "/projects/addGroupToGroup", method = RequestMethod.POST)
	public String addGroupToGroup(@RequestParam("groupName") String groupName,
			@RequestParam("parentGroupId") String parentGroupId,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		zoneManager.addGroupToGroup(groupName, parentGroupId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/addZone", method = RequestMethod.POST)
	public String addZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentGroupId") String parentGroupId,
			@RequestParam("projectId") String projectId, HttpServletRequest request) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			// TODO curiosity:CANT GET THIS MESSAGE EXPLICITLY!!
			logger.debug("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);
		zoneManager.addZone(zoneFromWeb, parentGroupId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/addAdditionalZone", method = RequestMethod.POST)
	public String addAdditionalZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			logger.debug("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);
		zoneManager.addAdditionalToZone(zoneFromWeb, parentZoneId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/addSurplusZone", method = RequestMethod.POST)
	public String addSurplusZone(@RequestParam("name") String name, @RequestParam("width") String width,
			@RequestParam("heigh") String height, @RequestParam("measureName") String measureName,
			@RequestParam("parentZoneId") String parentZoneId,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			logger.debug("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.addSurplusToZone(zoneFromWeb, parentZoneId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/removeZone", method = RequestMethod.POST)
	public String removeZone(@RequestParam("zoneId") String zoneId,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		zoneManager.removeZone(zoneId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/removeGroup", method = RequestMethod.POST)
	public String removeGroup(@RequestParam("groupId") String groupId,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		zoneManager.removeGroup(groupId);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/updateGroup", method = RequestMethod.POST)
	public String updateGroup(@RequestParam("groupId") String groupId,
			@RequestParam("groupName") String newGroup,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		zoneManager.updateGroup(groupId, newGroup);
		return "redirect:" + projectId;
	}

	@RequestMapping(value = "/projects/updateZone", method = RequestMethod.POST)
	public String updateZone(@RequestParam("zoneId") String zoneId, @RequestParam("name") String name,
			@RequestParam("width") String width, @RequestParam("heigh") String height,
			@RequestParam("measureName") String measureName,
			@RequestParam("projectId") String projectId,HttpServletRequest request) {

		ZoneData zoneFromWeb = new ZoneData();
		zoneFromWeb.setName(name);
		try {
			zoneFromWeb.setHeight(new Double(height).doubleValue());
			zoneFromWeb.setWidth(new Double(width).doubleValue());
		} catch (NumberFormatException exception) {
			logger.info("empty string from web!!!");
		}
		zoneFromWeb.setMeasureName(measureName);

		zoneManager.updateZone(zoneId, zoneFromWeb);
		return "redirect:" + projectId;
	}

}
