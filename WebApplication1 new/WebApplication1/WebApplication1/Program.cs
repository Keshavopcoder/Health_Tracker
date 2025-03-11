using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.Text;
using TrainerAPI.Repositories;
using WebApplication1.Data;
using WebApplication1.Repositories;
using WebApplication1.Repository.Interfaces;
using WebApplication1.Services;
using WebApplication1.Services.Implementation;
using WebApplication1.Services.Implementations;
using WebApplication1.Services.Interfaces;

var builder = WebApplication.CreateBuilder(args);


var jwtKey = builder.Configuration["Jwt:Key"];
var jwtIssuer = builder.Configuration["Jwt:Issuer"];

builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = jwtIssuer,
            ValidAudience = jwtIssuer,
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(jwtKey))
        };
    });


builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));


builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowReactApp", corsBuilder =>
    {
        corsBuilder.WithOrigins("http://localhost:5173") // Update if frontend is hosted elsewhere
                   .AllowAnyMethod()
                   .AllowAnyHeader();
    });
});


builder.Services.AddScoped<ITrainerRepository, TrainerRepository>();
builder.Services.AddScoped<IUserRepository, UserRepository>();
builder.Services.AddScoped<IOrderRepository, OrderRepository>();


builder.Services.AddScoped<ITrainerService, TrainerService>();
builder.Services.AddScoped<IUserServices, UserService>(); 
builder.Services.AddScoped<IOrderServices, OrderServices>();


builder.Services.AddControllers();

var app = builder.Build();


app.UseHttpsRedirection();
app.UseCors("AllowReactApp");
app.UseAuthentication();
app.UseAuthorization();


app.MapControllers();


app.Run();
