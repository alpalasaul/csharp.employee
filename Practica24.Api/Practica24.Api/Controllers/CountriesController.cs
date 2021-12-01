using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Practica24.Api.Models;
using Microsoft.EntityFrameworkCore;
using Practica24.Api.Repositories;


namespace Practica24.Api.Controllers
{
    [Route("api/[controller]")]
    public class CountriesController : ControllerBase
    {

        private readonly ICountryRepository countryRepository = null;

        public CountriesController(ICountryRepository countryRepository)
        {
            this.countryRepository = countryRepository;
        }


        [HttpGet]
        public List<Country> Get()
        {
            return countryRepository.SelectAll();
        }
    }
}
