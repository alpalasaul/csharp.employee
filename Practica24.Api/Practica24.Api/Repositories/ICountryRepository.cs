using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Practica24.Api.Models;


namespace Practica24.Api.Repositories
{
    public interface ICountryRepository
    {
        List<Country> SelectAll();
    }
}
